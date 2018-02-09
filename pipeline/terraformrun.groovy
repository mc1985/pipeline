// Pull code from git
node {
    stage "Pull code from git"
    git url: "https://github.com/mc1985/pipeline.git", branch: 'master'
// Build new terraform images
    stage "Build Docker Image"
    sh "docker build -f docker/terraform_base/Dockerfile -t terraform_base ."
// Run terraform container
   stage "Build custom Terraform Image"
    sh "docker run terraform_base init"
// push state file back to git repo
}
