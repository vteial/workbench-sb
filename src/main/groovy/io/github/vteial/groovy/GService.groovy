package io.github.vteial.groovy
import static org.mortbay.jetty.Handler.DEFAULT
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import org.mortbay.servlet.MultiPartFilter
import groovy.servlet.*

@Grapes([
    @Grab(group='org.mortbay.jetty', module='jetty-embedded', version='6.1.22')
])

def startJetty() {
    def jetty = new Server(9999)
    
    def context = new Context(jetty, '/', Context.SESSIONS)  // Allow sessions.
    context.resourceBase = '.'  // Look in current dir for Groovy scripts.
    context.setAttribute('version', '1.0')  // Set an context attribute.
    context.setAttribute('serverName', 'GService')
    
    context.addFilter(MultiPartFilter, '/*', DEFAULT)
    context.addServlet(GroovyServlet, '*.groovy')  // All files ending with .groovy will be served.
    context.addServlet(TemplateServlet, '*.gsp')  // All files ending with .gsp will be served.    
    context.addServlet(DefaultServlet, '/static/*').with {
        setInitParameter 'dirAllowed', 'true'
    }
    
    jetty.start()
    jetty.join()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()