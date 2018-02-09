folder('devops/Build/terraform')
pipelineJob('devops/Build/terraform/build_terraform_environment') {
  def repo = 'your repo here'
  definition {
    cpsScm {
      scm {
        git {
           remote { url(repo) }
           ScriptPath('pathtofile/terraformrun.groovy')
           extensions {}
            }
          }
        }
      }
    }
