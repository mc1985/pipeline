// Pull code from git
node {
    stage ("Pull code from git")
    git url: "https://github.com/mc1985/pipeline.git", branch: 'master'
// Build new terraform images
    stage ("Build Docker Image")
    sh "docker build -f docker/terraform_base/Dockerfile -t terraform_base ."
// Run terraform container
    stage ("run custom Terraform Image"){
    withCredentials([file(credentialsId:'terrafrom.tfvars', variable:'TFVARS')]) {
    sh "docker run -t --rm -e ACTION=plan -v $TFVARS=env-vars/terraform.tfvars terraform_custom"
// push state file back to git repo
}
