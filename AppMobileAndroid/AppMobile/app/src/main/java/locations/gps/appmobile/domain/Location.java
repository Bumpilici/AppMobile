package locations.gps.appmobile.domain;

public class Location
{
    private int m_ID;
    private String m_type;
    private String m_name;
    private String m_description;
    private double m_coordinateX;
    private double m_coordinateY;

    public Location()
    {
        m_ID=0;
        m_type="";
        m_name="";
        m_description="";
        m_coordinateX=0;
        m_coordinateY=0;
    }

    public Location(String f_type, String f_name, String f_description,double f_coordinateX, double f_coordinateY)
    {
        m_ID=0;
        m_type=f_type;
        m_name=f_name;
        m_description=f_description;
        m_coordinateX=f_coordinateX;
        m_coordinateY=f_coordinateY;
    }

    public Location(int f_ID, String f_type, String f_name, String f_description,double f_coordinateX, double f_coordinateY)
    {
        m_ID=f_ID;
        m_type=f_type;
        m_name=f_name;
        m_description=f_description;
        m_coordinateX=f_coordinateX;
        m_coordinateY=f_coordinateY;
    }

    public void setType(String f_type)
    {
        m_type=f_type;
    }

    public void setName(String f_name)
    {
        m_name=f_name;
    }

    public void setDescription(String f_description)
    {
        m_description=f_description;
    }

    public int getID()
    {
        return m_ID;
    }

    public String getType()
    {
        return m_type;
    }

    public String getName()
    {
        return m_name;
    }

    public String getDescription()
    {
        return m_description;
    }

    public String toString()
    {
        String l_string="";
        l_string+="Type: "+m_type+"\n";
        l_string+="Name: "+m_name+"\n";
        l_string+="Description: "+m_description+"\n";

        return l_string;
    }
}
