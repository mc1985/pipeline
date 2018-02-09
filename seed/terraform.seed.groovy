folder('devops')
folder('devops/Build')
folder('devops/Build/terraform')
folder('devops/Build/terraform')
pipelineJob('devops/Build/terraform/build_terraform_environment') {
  def repo = 'https://github.com/mc1985/pipeline.git'
  definition {
    cpsScm {
      scm {
        git {
           remote { url(repo) }
           scriptPath('pipeline/pipeline/terraformrun.groovy')
           extensions {}

            }
          }
        }
      }
    }
