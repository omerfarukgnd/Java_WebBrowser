package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;




public class TarayiciController  implements Initializable {
	// TANIMLAMALAR**
		@FXML private TabPane AnaSekme;
		@FXML AnchorPane AnaPanel;
		@FXML WebView ViewSayfa0;

		String htLink = "http://www.";

		//nesneler class'ýndan nesne oluþturabilmek için tanýmladým.
		Button btngit,btnileri,btngeri,btnyenile,btnekle,btnAnasayfa;
		WebView viewsayfa;
		TextField txtadres;
		Tab yenisekme;



		Tab sekmeolustur;
		Nesneler nesne=new Nesneler();



		@FXML
		public void onEnter(ActionEvent ae){
		   BtnGit(ae);
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1)
		{
			sekmeolustur=new Tab(" + ");//  yeni sekme oluþturmak için oluþturulan sekme
			EventHandler<Event> event =   new EventHandler<Event>() {  public void handle(Event e)  { NesnelerOlustur();}};
			sekmeolustur.setOnSelectionChanged(event);
			AnaSekme.getTabs().add(sekmeolustur);//yenisekme oluþturan sekmeyi ekledik.

			Tab tab = AnaSekme.getSelectionModel().getSelectedItem();
	        ObservableList<Node> dugum = ((Parent) tab.getContent()).getChildrenUnmodifiable();
	        WebView w = (WebView)dugum.get(6);
	        WebEngine e = w.getEngine();
	        e.load("http://www.google.com.tr");

		}
		public void NesnelerOlustur()
		{
			if(sekmeolustur.isSelected())
			{

		    	   btngit=nesne.btnGit();
		    	   btnekle=nesne.btnEkle();
		    	   btngeri=nesne.btnGeri();
		    	   btnileri=nesne.btnileri();
		    	   btnyenile=nesne.btnYenile();
		    	   viewsayfa=nesne.ViewSayfa();
		    	   txtadres=nesne.txtAdres();
		    	   yenisekme=nesne.Sekme();
		    	   btnAnasayfa=nesne.btnAnasayfa();

		    	   //butonatýkladýðýnda gerçekleþecek olaylarý vermek için
		    	   btngit.setOnAction(this::BtnGit);
		    	   btnekle.setOnAction(this::BtnEkle);
		    	   btngeri.setOnAction(this::BtnGeri);
		    	   btnileri.setOnAction(this::Btnileri);
		    	   btnyenile.setOnAction(this::BtnYenile);
		    	   btnAnasayfa.setOnAction(this::Anasayfa);


		    	   yenisekme.setContent(new Pane(btngeri,txtadres,btnileri,btnyenile,btnekle,btngit,viewsayfa,btnAnasayfa));
		    	   nesne.counter++;

			     AnaSekme.getTabs().add( AnaSekme.getTabs().size() - 1, yenisekme);
			     AnaSekme.getSelectionModel().select(AnaSekme.getTabs().size() - 2);

			     Tab tab = AnaSekme.getSelectionModel().getSelectedItem();
			        ObservableList<Node> dugum = ((Parent) tab.getContent()).getChildrenUnmodifiable();
			        WebView w = (WebView)dugum.get(6);
			        WebEngine e = w.getEngine();
			        e.load("http://www.google.com.tr");
		       }
		}

		@FXML public void BtnGit(ActionEvent event)
		   {
			WebEngine engine=new WebEngine();
			int index = AnaSekme.getSelectionModel().getSelectedIndex();//bulunduðumuz sekmenin index numarasýný alýr.
			String isim2="ViewSayfa"+Integer.toString(index);
		String	isim1="txtAdres"+Integer.toString(index);

			Set<Node> nodes2 = AnaPanel.lookupAll(".web-view");
			for( Node node: nodes2) {
				   if(node.getId().equals(isim2))
				   {
					   WebView sayfa=(WebView)node;
					   engine=sayfa.getEngine();
				   }
			}

		   Set<Node> nodes = AnaPanel.lookupAll(".text-field");
		   for( Node node: nodes) {
			   if(node.getId().equals(isim1))
			   {
				   TextField adres=(TextField) node;

				   String tmp;
				   if(adres.getText().contains("http")){
					   tmp = adres.getText();
				   }
				   else{
					   tmp = htLink+adres.getText()+".com";
				   }

				   engine.load(tmp);
				   adres.setText(engine.getLocation());

				   engine.titleProperty().addListener(new ChangeListener<String>()
			        {
			            public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			            {
			            	AnaSekme.getSelectionModel().getSelectedItem().setText (newvalue);
			            }
			        });
			   }
		   }
		   txtadres.setText(engine.getLocation());
		   }
		@FXML public void Btnileri(ActionEvent event)
		{
			WebEngine engine=new WebEngine();
			int index = AnaSekme.getSelectionModel().getSelectedIndex();//bulunduðumuz sekmenin index numarasýný alýr.
			String isim="ViewSayfa"+Integer.toString(index);

			Set<Node> nodes = AnaPanel.lookupAll(".web-view");
			for( Node node: nodes) {
				   if(node.getId().equals(isim))
				   {
					   WebView sayfa=(WebView)node;
					   engine=sayfa.getEngine();
					   engine.executeScript("history.forward()");
					  // yenisekme.setTitle(engine.getTitle());
					   AnaSekme.getSelectionModel().getSelectedItem().setText(engine.getLocation());//gidilen adresin konumunu alýr.

				   }
			}
			   txtadres.setText(engine.getLocation());

		}
		@FXML public void BtnGeri(ActionEvent event)
		{
			WebEngine engine=new WebEngine();
			int index = AnaSekme.getSelectionModel().getSelectedIndex();//bulunduðumuz sekmenin index numarasýný alýr.
			String isim="ViewSayfa"+Integer.toString(index);
			Set<Node> nodes = AnaPanel.lookupAll(".web-view");
			for( Node node: nodes) {
				   if(node.getId().equals(isim))
				   {
					   WebView sayfa=(WebView)node;
					   engine=sayfa.getEngine();
					   engine.executeScript("history.back()");
					   AnaSekme.getSelectionModel().getSelectedItem().setText(engine.getLocation());//gidilen adresin konumunu alýr.
				   }
			}
			   txtadres.setText(engine.getLocation());

		}
		@FXML public void BtnYenile(ActionEvent event)
		{

			WebEngine engine=new WebEngine();
			int index = AnaSekme.getSelectionModel().getSelectedIndex();//bulunduðumuz sekmenin index numarasýný alýr.
			String isim="ViewSayfa"+Integer.toString(index);
			Set<Node> nodes = AnaPanel.lookupAll(".web-view");
			for( Node node: nodes) {
				   if(node.getId().equals(isim))
				   {
					   WebView sayfa=(WebView)node;
					   engine=sayfa.getEngine();
					   engine.reload();
				   }
			}
			txtadres.setText(engine.getLocation());

		}
		@FXML public void BtnEkle(ActionEvent event){

		}

		@FXML public void gecmisAc(){

		}

		@FXML public void Anasayfa(ActionEvent event){
			WebEngine engine=new WebEngine();
			int index = AnaSekme.getSelectionModel().getSelectedIndex();//bulunduðumuz sekmenin index numarasýný alýr.
			String isim2="ViewSayfa"+Integer.toString(index);
		String	isim1="txtAdres"+Integer.toString(index);

			Set<Node> nodes2 = AnaPanel.lookupAll(".web-view");
			for( Node node: nodes2) {
				   if(node.getId().equals(isim2))
				   {
					   WebView sayfa=(WebView)node;
					   engine=sayfa.getEngine();

				   }
			}

		   Set<Node> nodes = AnaPanel.lookupAll(".text-field");
		   for( Node node: nodes) {
			   if(node.getId().equals(isim1))
			   {
				   String adres="google";
				   String tmp = htLink+adres+".com";
				   engine.load(tmp);
				   txtadres.setText(engine.getLocation());

				   engine.titleProperty().addListener(new ChangeListener<String>()
			        {
			            public void changed(ObservableValue<? extends String> ov,
			            final String oldvalue, final String newvalue)
			            {
			            	AnaSekme.getSelectionModel().getSelectedItem().setText (newvalue);
			            }
			        });
			   }
		   }
		   txtadres.setText("http:/www.google.com");
		}






}