// Create Your Folder Structure Below
folder('devops')
folder('devops/Build')
folder('devops/Build/terraform')
  def env = 'stage'
  def stack = 'appstack'
pipelineJob('devops/Build/terraform/create_${env}_${stack}_terraform') {
  def repo = 'https://github.com/mc1985/pipeline.git' // Put your GIT URL HERE
  definition {
    cpsScm {
      scm {
        git {
           remote { url(repo) }
           scriptPath('pipeline/${env}_${stack}_terraform_create.groovy')  // Put the Path to the Pipeline Job
           extensions {}
            }
          }
        }
      }
    }
pipelineJob('devops/Build/terraform/destroy_${env}_${stack}_terraform') {
  def repo = 'https://github.com/mc1985/pipeline.git' // Put your GIT URL HERE
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          scriptPath('pipeline/${env}_${stack}_terraform_destroy.groovy')  // Put the Path to the Pipeline Job
          extensions {}
                }
              }
            }
          }
        }
