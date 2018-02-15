// Create Your Folder Structure Below
def env = 'stage'       // environment key
def stack = 'appstack'  //application stack name
def repo = 'https://github.com/mc1985/pipeline.git' // Put your GIT URL HERE

folder('deploy')
folder("deploy/${stack}")
folder("deploy/${stack}/${env}")
pipelineJob("devops/Build/terraform/create_${env}_${stack}_terraform") {
  definition {
    cpsScm {
      scm {
        git {
           remote { url(repo) }
           scriptPath("pipeline/${env}_${stack}_terraform_create.groovy")  // Put the Path to the Pipeline Job
           extensions {}
            }
          }
        }
      }
    }
pipelineJob("devops/Build/terraform/destroy_${env}_${stack}_terraform") {
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          scriptPath("pipeline/${env}_${stack}_terraform_destroy.groovy")  // Put the Path to the Pipeline Job
          extensions {}
                }
              }
            }
          }
        }
