# Spring Boot CLI - Initializer Examples

You can initialize your Spring Boot project by executing the following command:
```bash
$ spring init  --build gradle myapp
```

If you want to add some other features like web or jpa, you can execute:
```bash
$ spring init -dweb,data-jpa,h2,thymeleaf --build maven myapp
```

You can also execute just the ___spring___ command to get all the available options.
 ```
$ spring
usage: spring [--help] [--version]
       <command> [<args>]

Available commands are:

  run [options] <files> [--] [args]
    Run a spring groovy script

  test [options] <files> [--] [args]
    Run a spring groovy script test

  grab
    Download a spring groovy scripts dependencies to ./repository

  jar [options] <jar-name> <files>
    Create a self-contained executable jar file from a Spring Groovy script

  war [options] <war-name> <files>
    Create a self-contained executable war file from a Spring Groovy script

  install [options] <coordinates>
    Install dependencies to the lib directory

  uninstall [options] <coordinates>
    Uninstall dependencies from the lib directory

  init [options] [location]
    Initialize a new project using Spring Initializr (start.spring.io)

  shell
    Start a nested shell

Common options:

  -d, --debug Verbose mode
    Print additional status information for the command you are running


See 'spring help <command>' for more information on a specific command.
 ```
