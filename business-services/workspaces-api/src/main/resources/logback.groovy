import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import net.logstash.logback.appender.LogstashTcpSocketAppender
import net.logstash.logback.encoder.LogstashEncoder

def appHost = "localhost"
def appName = "workspaces-api"
def logstashHost = "localhost"
def logstashPort = 5000

println "=" * 80
println """
    APP NAME        : $appName
    APP HOST        : $appHost
    LOGSTASH HOST   : $logstashHost
    LOGSTASH PORT   : $logstashPort
        """
println "=" * 80

def appenderList = []

if (logstashHost){
    appender("logback", LogstashTcpSocketAppender){
        remoteHost = logstashHost
        port = logstashPort.toInteger()
        encoder(LogstashEncoder)
    }
    appenderList << 'logback'
}

appender("console", ConsoleAppender){
    encoder(PatternLayoutEncoder){
        pattern = "%-4relative %d %-5level [ %t ] %-5logger{13} | %m %n"
    }
}
appenderList << 'console'

root(INFO, appenderList)