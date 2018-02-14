// Pull code from git
node {
    stage "Pull code from git"
    git url: "https://github.com/mc1985/pipeline.git", branch: 'master' //Add your Git URL and Branch for the terraform Project
// Build new terraform images
    stage "Build terrafrom Docker Image"
     sh "docker build -f docker/terraform_base/Dockerfile -t terraform_base ."
// Run terraform plan
    stage "Run Terraform Plan"
     sh "docker run terraform_base plan"
// Run terraform apply
    stage "Run Terraform apply"
     sh "docker run terraform_base apply"
}
