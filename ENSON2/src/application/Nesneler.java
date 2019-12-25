package application;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class Nesneler {


	public int counter=1;
	public String num;
	public TextField txtAdres()
	{
		int sayac=counter;
		num=Integer.toString(sayac);
		TextField txt=new TextField();
		txt.setId("txtAdres"+num);//name
		txt.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; ");
		txt.setMinSize(540, 31);//Boyutu vermek için
	    txt.setTranslateX(290);//konum verir
	    txt.setTranslateY(10);//konum verir
	    return txt;
	}

	public Button btnGeri()
	{
		int sayac=counter; num=Integer.toString(sayac);
        Button btn = new Button("");
	    btn.setId("btnGeri"+num);
	    btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/geri.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
	    btn.setTranslateX(10);
	    btn.setTranslateY(10);
	    btn.setMinSize(60, 31);
	    return btn;
	}

	public Button btnileri()
	{
		int sayac=counter;num=Integer.toString(sayac);
		Button btn = new Button("");
		btn.setId("btnileri"+num);
		btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/ileri.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
	    btn.setTranslateX(80);
	    btn.setTranslateY(10);
	    btn.setMinSize(60, 31);
	    return btn;
	}

	public Button btnYenile()
	{
		int sayac=counter;num=Integer.toString(sayac);
		Button btn=new Button("");
		btn.setId("btnYenile"+num);
		btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/guncelle.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
	    btn.setTranslateX(150);
	    btn.setTranslateY(10);
	    btn.setMinSize(60, 31);
	    return btn;
	}

	public Button btnAnasayfa()
	{
		int sayac=counter;num=Integer.toString(sayac);
		Button btn=new Button("");
		btn.setId("btnAnasayfa"+num);
		btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/if_Home_100231.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
	    btn.setTranslateX(220);
	    btn.setTranslateY(10);
	    btn.setMinSize(60, 31);
	    return btn;
	}

	public Button btnEkle()
	{
		int sayac=counter;num=Integer.toString(sayac);
		Button btn=new Button("");
		btn.setId("btnEkle"+num);
		btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/plus-icon.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
	    btn.setTranslateX(910);//konum verir
	    btn.setTranslateY(10);//konum verir
	    btn.setMinSize(60, 31);


	    return btn;
	}



    public Button btnGit()
    {
    	int sayac=counter;num=Integer.toString(sayac);
    	Button btn=new Button("");
    	btn.setId("btnGit"+num);
    	btn.setStyle("-fx-background-radius: 5em; -fx-background-color: -fx-body-color; -fx-contentDisplay=CENTER; -fx-background-image:url('/foto/icon-search-128.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
        btn.setTranslateX(840);//konum verir
        btn.setTranslateY(10);//konum verir
        btn.setMinSize(60, 31);
        return btn;
    }

    public WebView ViewSayfa()
    {
		int sayac=counter;num=Integer.toString(sayac);
		WebView  View=new WebView();
		View.setId("ViewSayfa"+num);
		View.setTranslateX(0);//konum verir
		View.setTranslateY(50);//konum verir
		View.setPrefSize(1920, 976);
	    return View;
    }



	public Tab Sekme() {
		int sayac=counter;num=Integer.toString(sayac);
		Tab yenisekme = new Tab("Yeni Sekme");
		yenisekme.setId("tbsekme"+num);
		return yenisekme;
	}


}