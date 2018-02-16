#!/bin/sh
export PATH=$PATH:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin
cd /app/

terraform init

case ${ACTION} in
  "plan")
    terraform plan -var-file=/seurity/terraform.tfvars
    ;;
  "apply")
    terraform apply -var-file=/seurity/terraform.tfvars
    ;;
  "destroy")
    terraform destroy -var-file=/seurity/terraform.tfvars
    ;;
  *)
    exit 0
esac
