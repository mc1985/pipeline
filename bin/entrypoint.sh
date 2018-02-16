#!/bin/sh
export PATH=$PATH:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin
cd /app/

terraform init

case ${ACTION} in
  "plan")
    terraform plan -var-file=/security/terraform.tfvars
    ;;
  "apply")
    terraform apply -var-file=/security/terraform.tfvars
    ;;
  "destroy")
    terraform destroy -var-file=/security/terraform.tfvars
    ;;
  *)
    exit 0
esac
