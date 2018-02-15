#!/bin/sh
export PATH=$PATH:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin
cd /app/

terraform init

case ${ACTION} in
  "plan")
    terraform plan
    ;;
  "apply")
    terraform apply
    ;;
  "destroy")
    terraform destroy
    ;;
  *)
    exit 0
esac
