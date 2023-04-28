# Spaces Core Repository


### Design Architecture
<img src="Arquitetura.png">

### How to Setup Terraform and Docker Infras
````shell
docker compose up -d
````
To run the Localstack and Prometheus, Grafana

````shell
tflocal init

tflocal validate

tflocal plan -var-file=environments/dev/dev.tfvars

tflocal apply -var-file=environments/dev.tfvars

````
To run local the environment AWS and Observability integrations