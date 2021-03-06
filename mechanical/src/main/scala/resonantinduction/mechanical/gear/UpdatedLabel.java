package resonantinduction.mechanical.gear;

import java.awt.Label;

/** Simple label with an update method
 * 
 * @author Darkguardsman */
@SuppressWarnings("serial")
public class UpdatedLabel extends Label
{
    String start_string = "I Am a Label";

    public UpdatedLabel(String start)
    {
        super(start);
        this.start_string = start;
    }

    /** Called to update the content of the label */
    public void update()
    {
        this.setText(buildLabel());
    }

    /** Recreates then returns the label's string value */
    public String buildLabel()
    {
        return start_string;
    }
}
