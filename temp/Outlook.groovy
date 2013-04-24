/*
// @Grab(group='', module='', version='')

@Grapes([
    @Grab(group='org.slf4j', module='slf4j-api', version='1.5.11'),
    @Grab(group='org.slf4j', module='slf4j-simple', version='1.5.11'),
    @Grab(group='com.google.guava', module='guava', version='r12'),
])
*/

import java.util.Properties
import java.io.FileInputStream

import org.codehaus.groovy.scriptom.*;
import org.codehaus.groovy.scriptom.tlb.office.outlook.OlDefaultFolders;
import org.codehaus.groovy.scriptom.tlb.office.outlook.OlAttachmentType;

println '-------------------------------------------------------------------'

def defaultProps = [ 
    'folderToParse'         : 'Mailbox - directconnecthelp',
    'from'                  : 'eialarasu.thandapani@lastminute.com',
    'to'                    : 'eialarasu.thandapani@lastminute.com',
    'subject'               : 'DirectconnectHelp Mailbox Status',
    'senderName'            : 'Eialarasu',
    'subjectListingFolders' : '/Inbox/Tech,/Inbox/Tech/In Progress - Sandy,/Inbox/Tech/In Progress - Niraj,/Inbox/Tech/In Progress - Krishna M,/Inbox/Tech/In Progress - Bev.,/Inbox/Tech/In Progress - Arindam,/Inbox/Tech/In Progress - Amlan'
    ]
def props = defaultProps
//println props
def file = new File('outlook.properties')
if(file.exists()) {
    def propsFile = new Properties()
    propsFile.load(new FileInputStream(file))
    props << propsFile
}
props.subjectListingFolders = props.subjectListingFolders.tokenize(',')
println props.subjectListingFolders.join(' \n')
//println props    

def parseFolder = { folder ->
    def subjectListingFolders = props.subjectListingFolders
    //println subjectListingFolders
    def results = new StringBuilder()

    results << "/$folder.Name = $folder.Items.Count.value\n"
    def cfn = '/' + folder.Name
    if(subjectListingFolders.contains(cfn)) {
        int i = 0
        folder.Items.each { item ->
            i++
            results << "\t$i\t$item.Subject\t$item.ReceivedTime\n"
        }
        results << "\n"
    }
    
    folder.Folders.each { subFolder ->
        results << "\t/$folder.Name/$subFolder.Name = $subFolder.Items.Count.value\n"
        cfn = '/' + folder.Name + '/' + subFolder.Name
        if(subjectListingFolders.contains(cfn)) {
            int i = 0
            subFolder.Items.each { item ->
                i++
                results << "\t\t$i\t$item.Subject\t$item.ReceivedTime\n"
            }
            results << "\n"
        }
        
        subFolder.Folders.each { subSubFolder ->
            results << "\t\t/$folder.Name/$subFolder.Name/$subSubFolder.Name = $subSubFolder.Items.Count.value\n"
            cfn = '/' + folder.Name + '/' + subFolder.Name + '/' + subSubFolder.Name
            if(subjectListingFolders.contains(cfn)) {
                int i = 0
                subSubFolder.Items.each { item ->
                    i++
                    results << "\t\t\t$i\t$item.Subject\t$item.ReceivedTime\n"
                }
                results << "\n"
            }

            subSubFolder.Folders.each { subSubSubFolder ->
                results << "\t\t\t/$folder.Name/$subFolder.Name/$subSubFolder.Name/$subSubSubFolder.Name = $subSubSubFolder.Items.Count.value\n"
                cfn = '/' + folder.Name + '/' + subFolder.Name + '/' + subSubFolder.Name + '/' + subSubSubFolder.Name
                if(subjectListingFolders.contains(cfn)) {
                    int i = 0
                    subSubSubFolder.Items.each { item ->
                        i++
                        results << "\t\t\t\t$i\t$item.Subject\t$item.ReceivedTime\n"
                    }
                    results << "\n"
                }
               
           }
        }
    }
    return results
}

Scriptom.inApartment {

    def outlook = new ActiveXObject('Outlook.Application')
    def namespace = outlook.GetNamespace('MAPI')
    namespace.Stores.each { store ->
        def rootFolder = store.GetRootFolder()
        //println("$rootFolder.FolderPath =  $rootFolder.Name")
        if(rootFolder.Name.equals(props['folderToParse'])) {
            //def results = parseFolder(rootFolder)
            def results1 = parseFolder(rootFolder.Folders('Inbox'))
            //println results1
            def results2 = parseFolder(rootFolder.Folders('Deleted Items'))
            //println results2
            def results = results1.toString() +  results2.toString()
            results += "\nThanks and Regards,\n$props.senderName"
            println results
            
            def mailItem = outlook.CreateItem(0);
            def recp = mailItem.Recipients.add(props.to);
            recp.Type = 1 // To = 1, CC = 2, BCC = 3
            mailItem.Subject = props.subject
            mailItem.Body = results.toString()
            mailItem.Display(true);
        }
    }
    
}

println '-------------------------------------------------------------------'