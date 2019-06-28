# Quick Start MongoDB (Ubuntu 18.04 / Mint 19.1)
#### 1. Update system:
```bash
sudo apt-get update && sudo apt-get upgrade
```
#### 2. [Install Docker](https://github.com/snikulitsa/useful/blob/master/DOCKER.md)
#### 3. Reopen `terminal` and run commands:
```bash
docker pull bitnami/mongodb
docker run -p 27017:27017 --name mongodb bitnami/mongodb:latest
```