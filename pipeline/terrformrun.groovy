// Pull code from git
node {
      stage "Pull code from git"
      scm {
          git {
              remote {
                  name('terraform module')
                  url('https://github.com/mc1985/pipeline.git')
        }
          }
            }

}
// Build new terraform images
    stage "Build Docker Image"
    sh "docker build -f docker/terraform_base/Dockerfile -t terraform_base ."
// Run terraform container
   stage "Run Terraform Image"
    sh "docker run terraform_base"
// push state file back to git repo
