package org.example;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class App
{
    public static void main( String[] args )
    {
        try(CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("localhost",9042))
                .withLocalDatacenter("datacenter1")
                .withKeyspace("dragon")
                .build()){

            ResultSet resultSet= cqlSession.execute("select * from dragon.dragons");
            for(Row row: resultSet){
                int country =row.getInt("country");
                int id =row.getInt("id");
                String name=row.getString("name");

                System.out.println(id+ " " + country+ " "+ name);
            }

        }
    }
}
