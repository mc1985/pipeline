pipeline {
  agent {
    label 'orlando-win-7'
  }
  options {
    timestamps()
  }
// Pull code from git
stages {
    stage ("Pull code from git")
    git url: "", branch: '' //Add your Git URL and Branch for the terraform Project
// Build new terraform images
    stage ("Build Docker Image")
    sh "docker build -t terraform_custom ."
// Run terraform container
   stage ("run custom Terraform Image"){
     withCredentials([file(credentialsId:'aws_staging.tfvars', variable:'TFVARS')]) {
    sh "docker run -t --rm -e ACTION=plan -v $TFVARS=env-vars/aws_staging.tfvars terraform_custom"
  }
 }
}
