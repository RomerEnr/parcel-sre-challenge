#!/usr/bin/env bash

set -euo pipefail

# Check if Minikube is already installed
if command -v minikube &> /dev/null; then
    echo "Minikube is already installed"
else
    # Check OS type (Linux or macOS), and set environment variable for Minikube binary
    if [[ "$OSTYPE" == "linux-gnu"* ]]; then
        MINIKUBE_BINARY_URL="https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64"
    elif [[ "$OSTYPE" == "darwin"* ]]; then
        MACHINE_TYPE=$(uname -m)
        # For Intel Macs (amd64)
        if [[ "$MACHINE_TYPE" == "x86_64" ]]; then
            MINIKUBE_BINARY_URL="https://storage.googleapis.com/minikube/releases/latest/minikube-darwin-amd64"
        # For M1/M2 Macs (arm64)
        elif [[ "$MACHINE_TYPE" == "arm64" ]]; then
            MINIKUBE_BINARY_URL="https://storage.googleapis.com/minikube/releases/latest/minikube-darwin-arm64"
        else
            echo "Unsupported machine type: $MACHINE_TYPE"
            exit 1
        fi
    else
        echo "Unsupported OS: $OSTYPE"
        exit 1
    fi
    # Download Minikube binary, and place it into a $PATH directory
    curl -Lo ./minikube $MINIKUBE_BINARY_URL
    chmod +x ./minikube
    sudo mv ./minikube /usr/local/bin/minikube
    echo "Minikube installed successfully"
fi

# Add user to Docker group if Docker is installed
if command -v docker &> /dev/null; then
    echo "Adding user to the Docker group..."
    sudo usermod -aG docker $USER
else
    echo "Docker is not installed. Minikube will need Docker to run."
fi

# Inform user to manually start Minikube
echo "Run 'minikube start --driver=docker' to start Minikube with Docker driver."
