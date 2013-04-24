def method = request.method

if (!session) {
    session = request.getSession(true)
}

if (!session.groovlet) {
}
println '<!doctype html>'
html.html {
head {
    title 'GServer Info'
    script type : 'text/javascript', src : 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js'
    
    script( type : 'text/javascript', src : 'http://current.bootstrapcdn.com/bootstrap-v204/js/bootstrap.min.js')
    link( rel : 'stylesheet', type : 'text/css', href : 'http://current.bootstrapcdn.com/bootstrap-v204/css/bootstrap-combined.min.css')
    link( rel : 'stylesheet', type : 'text/css', href : 'http://current.bootstrapcdn.com/bootstrap-v204/css/bootstrap-responsive.min.css')
    
    link( rel : 'stylesheet', type : 'text/css', href : 'http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css' )
    script( type : 'text/javascript', src : 'http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css' )
    
    style( type : 'text/css') {
        mkp.yield('''
        body {
            padding-top: 60px;
        }
        
        .center {
            text-align: center;
        }
    ''')
    }
}
body {
    div( class : 'navbar navbar-fixed-top') {
        div( class : 'navbar-inner') {
            div( class : 'container') {
                ul( class : 'nav') {
                    li( class : ' ') { 
                        a( href : 'gserverInfo.groovy', class : 'brand' ) { 
                            strong( 'GService' )
                        }
                    }       
                }
                ul( class : 'nav pull-right') {
                    li( class : ' ') { a( href : '#', 'About') }
                }
            }
        }
    }
    
    div( class : 'container') {
        p( 'Welcome to GService aka Groovy Service!' )
    }
    
    div( class : 'container') {
        ul( id : 'infoTab', class : 'nav nav-tabs') {
            li( class : 'active') { a('General Info', href : '#generalInfo', 'data-toggle' : 'tab' ) }
            li { a('Header Info', href : '#headerInfo', 'data-toggle' : 'tab' ) }
            li { a('System Info', href : '#systemInfo', 'data-toggle' : 'tab' ) }                                
            li { a('JVM Info', href : '#jvmInfo', 'data-toggle' : 'tab' ) }                
            li { a('GService Code', href : '#gserviceCode', 'data-toggle' : 'tab' ) }
            li { a('Available Scripts', href : '#availableScripts', 'data-toggle' : 'tab' ) }
        }
        div( id : 'infoTabContent', class : 'tab-content') {
            div( id : 'generalInfo', class : 'tab-pane fade in active') {
                table( class : 'table table-striped table-condensed') { thead {
                        tr {
                            th( '#', width : '20')
                            th( 'Name')
                            th( 'Value')
                        }
                    }
                    tbody {
                        tr {  
                            td( '1' )
                            td( 'Method' )
                            td( "${request.method}" )
                        }
                        tr {  
                            td( '2' )
                            td( 'Request URI' )
                            td( "${request.requestURI}" )
                        }
                        tr {  
                            td( '3' )
                            td( 'App Version' )
                            td( "${context.version}" ) 
                        } 
                    }
                }
            }
            
            div( id : 'headerInfo', class : 'tab-pane fade') {
                table( class : 'table table-striped table-condensed') { thead {
                        tr {
                            th( '#', width : '20')
                            th( 'Name')
                            th( 'Value')
                        }
                    }
                    tbody {
                    int i = 0
                    headers.each { h -> 
                        i++
                        tr { 
                            td( "${i}" )
                            td( "${h.key}" )
                            td( "${h.value}" )
                        }
                    }
                    }
                }
            }

            div( id : 'systemInfo', class : 'tab-pane fade') {
                table( class : 'table table-striped table-condensed') { thead {
                        tr {
                            th( '#', width : '20')
                            th( 'Name')
                            th( 'Value')
                        }
                    }
                    tbody {
                    int i = 0
                    System.getenv().each { k, v -> 
                        i++
                        tr { 
                            td( "${i}" )
                            td( "${k}" )
                            td( "${v}" )
                        }
                    }
                    }
                }
            }
            
            div( id : 'jvmInfo', class : 'tab-pane fade') {
                table( class : 'table table-striped table-condensed') { thead {
                        tr {
                            th( '#', width : '20')
                            th( 'Name')
                            th( 'Value')
                        }
                    }
                    tbody {
                    int i = 0
                    System.properties.each { k, v -> 
                        i++
                        tr { 
                            td( "${i}" )
                            td( "${k}" )
                            td( "${v}" )
                        }
                    }
                    }
                }
            }
            
            div( id : 'gserviceCode', class : 'tab-pane fade') {
                def file = new File('gserviceInfo.groovy')
                pre( "${file.text}", class : 'prettyprint lang-groovy' )
            }

            div( id : 'availableScripts', class : 'tab-pane fade') {
                table( class : 'table table-striped table-condensed') { thead {
                        tr {
                            th( '#', width : '20')
                            th( 'Script Name')
                            th( ' ')
                        }
                    }
                    tbody {
                    File dir = new File('.')                        
                    int i = 0
                    dir.eachFile { f -> 
                        if(f.name != 'gservice.groovy' && f.name.endsWith('.groovy')) {
                        i++
                        tr { 
                            td( "${i}" )
                            td { a( href : "${f.name}", "${f.name}" ) }
                            td( ' ')
                        }
                        }
                    }
                    }
                }
            }

        }
    }
}
}