package locations.gps.appmobile.domain;

public class Location
{
    private String m_type;
    private String m_name;
    private String m_description;
    private double m_coordinateX;
    private double m_coordinateY;

    public Location()
    {
        m_type="";
        m_name="";
        m_description="";
        m_coordinateX=0;
        m_coordinateY=0;
    }

    public Location(String f_type, String f_name, String f_description,double f_coordinateX, double f_coordinateY)
    {
        m_type=f_type;
        m_name=f_name;
        m_description=f_description;
        m_coordinateX=f_coordinateX;
        m_coordinateY=f_coordinateY;
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
