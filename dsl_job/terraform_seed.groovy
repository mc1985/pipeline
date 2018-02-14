// Create Your Folder Structure Below
folder('devops')
folder('devops/Build')
folder('devops/Build/terraform')
pipelineJob('devops/Build/terraform/Create_terraform_environment') {
  def repo = 'https://github.com/mc1985/pipeline.git' // Put your GIT URL HERE
  definition {
    cpsScm {
      scm {
        git {
           remote { url(repo) }
           scriptPath('pipeline/env_terraform_create.groovy')  // Put the Path to the Pipeline Job
           extensions {}
            }
          }
        }
      }
    }
pipelineJob('devops/Build/terraform/destroy_terraform_environment') {
  def repo = 'https://github.com/mc1985/pipeline.git' // Put your GIT URL HERE
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          scriptPath('pipeline/env_terraform_destroy.groovy')  // Put the Path to the Pipeline Job
          extensions {}
                }
              }
            }
          }
        }
