// Pull code from git
node {
      stage "Pull code from git"
      scm {
          git {
              remote {
                  name('terraform module')
                  url('')
        }
          }
            }
  
}
// Build new terraform images
    stage "Build Docker Image"
    sh docker build -t azure-test-app .
// Run terraform container
   stage "Run Terraform Image"
    sh docker run terraform_run
// push state file back to git repo
