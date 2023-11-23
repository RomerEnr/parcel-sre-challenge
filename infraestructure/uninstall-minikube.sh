#!/usr/bin/env bash

set -euo pipefail

# Check if a Minikube cluster is running and delete it if it exists
if minikube status > /dev/null 2>&1; then
  echo "Deleting Minikube cluster..."
  minikube delete
  echo "Minikube cluster deleted successfully"
else
  echo "Minikube cluster is not currently running."
fi

# Uninstall Minikube binary if it exists
if [ -e /usr/local/bin/minikube ]; then
  echo "Uninstalling Minikube..."
  sudo rm /usr/local/bin/minikube
  echo "Minikube uninstalled successfully"
else
  echo "Minikube is not installed in /usr/local/bin"
fi
