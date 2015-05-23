package theframework;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.Contacts;
import android.util.Log;

/**
 * Created by ioedu on 23/05/15.
 */
public class ComponentTest
{
    public ComponentTest()
    {
        //constructor
        this.helloworld();
    }

    public void helloworld()
    {
        Log.d("COMPONENT TEST","HELLO WORLD");
    }


    public void access(ContentResolver oCR)
    {
        //getContentResolver() is method of class android.content.Context, so to call it you definitely need an instance of Context ( Activity or Service for example).
        //ContentResolver oCR = getContentResolver();
        Cursor oCursor = oCR.query(Contacts.People.CONTENT_URI,null,null,null,null);
        if(oCursor.getCount()>0)
        {
            while (oCursor.moveToNext())
            {
                String sId = oCursor.getString(oCursor.getColumnIndex(Contacts.People._ID));
                String sName = oCursor.getString(oCursor.getColumnIndex(Contacts.People.NAME));
                Log.d("DATOS CONTACTO",sId+":"+sName);
            }
        }
    }

}
