// Pull code from git
node {
    stage ("Pull code from git")
    git url: "https://github.com/mc1985/pipeline.git", branch: 'master'
// Build new terraform images
    stage ("Build Docker Image") {
    sh "docker build -f Dockerfile -t terraform_base ."
  }
// Run terraform container
    stage ("run custom Terraform Image"){
    withCredentials([file(credentialsId:'terraform.tfvars', variable:'TFVARS')]) {
    sh "docker run -t --rm -e ACTION=plan -v ${TFVARS}:/terraform.tfvars terraform_base"
  }
}
// push state file back to git repo
}
