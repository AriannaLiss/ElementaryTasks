package task5_number_to_words;

import general.Dialog;

public class Application {
    private Dialog dialog;

    Application(Dialog dialog){
        this.dialog = dialog;
    }

    public void run(String[] args){
        /*for(String num: args){
            dialog.print(num+": "+NumberInWords.toString(Integer.parseInt(num))+"\n");
        }*/
      //  for (int i=1000;i<10000;i++){
       int i=9998;
            dialog.print(i+": "+ NumberToWords.toString(i)+"\n");
    //    }
    }
}
