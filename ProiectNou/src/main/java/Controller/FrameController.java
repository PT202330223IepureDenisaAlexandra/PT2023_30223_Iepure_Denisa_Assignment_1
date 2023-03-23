package Controller;

//import app.Design_form;

import view.Design_form;
public class FrameController {
    public void startLogic()
    {
        Design_form designForm = new Design_form();
        GUIFrameContrl.changePanel(designForm.getMainPanel(),"Calculator");

    }

}
