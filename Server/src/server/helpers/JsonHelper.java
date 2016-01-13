package server.helpers;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by r on 12/01/16.
 */
public class JsonHelper
{
    public static JsonArray getJsonArrayFromFilename (String name)
    {
        StringBuilder builder = new StringBuilder ();

        try
        {
            File f = new File ( name );
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                builder.append ( s.nextLine () );
            }
        }
        catch ( IOException ex )
        {
            System.out.println ();
        }

        return (JsonArray)new JsonParser ().parse ( builder.toString () );
    }
}