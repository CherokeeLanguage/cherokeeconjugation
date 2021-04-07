package net.cherokeedictionary.util


import groovy.sql.Sql

/**
 *
 * @author torr
 * @since 2/21/14 6:55 PM
 */
class SQLClass {
    static def DRIVER_NAME = "com.mysql.cj.jdbc.Driver"//'org.gjt.mm.mysql.Driver'

    static def SQL = Sql.newInstance( 'jdbc:mysql://localhost/cherokeedictionary?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=America/Chicago', 'root', 'Tk02030#', DRIVER_NAME )
}