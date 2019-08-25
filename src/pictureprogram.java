
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class pictureprogram extends Application  {

	int i = 0;
	ArrayList<Image> img = new ArrayList<Image>();
	HBox box = new HBox();
	BorderPane borderPane = new BorderPane();
	Scene scene = new Scene(borderPane, 500, 500);
	@Override 
	public void start(Stage stage) throws Exception {



		box.setSpacing(10);
		box.setAlignment(Pos.BOTTOM_CENTER);
		Button next = new Button("Next");
		Button prev = new Button("Previous");
		Button slide = new Button("SlideShow");
		Button stop = new Button("Stop");
		box.getChildren().addAll(prev,next,slide,stop);

		Image Image1 = new Image("file:///C:/Users/Moiz/Desktop/Saeed_GUI/image/1.jpg");
		Image Image2 = new Image("file:///C:/Users/Moiz/Desktop/Saeed_GUI/image/2.jpg");
		Image Image3 = new Image("file:///C:/Users/Moiz/Desktop/Saeed_GUI/image/3.jpg");
		Image Image4 = new Image("file:///C:/Users/Moiz/Desktop/Saeed_GUI/image/4.jpg");
		Image Image5 = new Image("file:///C:/Users/Moiz/Desktop/Saeed_GUI/image/5.jpg");


		img.add(Image1);img.add(Image2);img.add(Image3);img.add(Image4);img.add(Image5);

		EventHandler<ActionEvent> eventHandler = e -> {
			if (i < 4) {
				i = i+1;
				display(stage);
			}
			else{
				i = 0;
				display(stage);
			}


		};
		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),eventHandler));

		//next
		next.setOnAction((e) -> {
			 nextpic();
			display(stage);
		});

		//back
		prev.setOnAction((e) -> {
			 prevpic();
			display(stage);

		});
		//slideshow
		slide.setOnAction((e) -> {
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		});
		//stop
		stop.setOnAction((e) -> {
			animation.pause();
		});
		borderPane.setOnKeyPressed(e -> { //e is a KeyEvent
		      if (e.getCode() == KeyCode.N) {
		    	  nextpic();
		    	}
					
		      else if (e.getCode() == KeyCode.P) {
		    	  prevpic();
		      }
		    	  display(stage);
		    });
		borderPane.setOnMouseClicked(e -> {
	      
	    		BorderPane border = (BorderPane)e.getSource();
	  
	        if (e.getX() >= 0 && e.getX() <= border.getWidth()/2) {
	          nextpic();
	          display(stage);
	        }
	        else {
	        	prevpic();
	        	display(stage);
	        }
	      });

		display(stage);


	}
	public void nextpic() {
		  if(i<4) {
				i= i+1;
			}
			else if(i == 4) {
				i = 0;
			}
		  ImageView iv = new ImageView(img.get(i));   
			iv.setFitWidth(200);
			iv.setPreserveRatio(true);
	}
	public void prevpic() {
		if(i>0) {
			i= i-1;
		}
		else if(i == 0) {
			i = 4;
		}
	}
	public void display(Stage stage) {
		ImageView iv = new ImageView(img.get(i));   
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		box.setStyle("-fx-background-color: black;");
		
		borderPane.setCenter(iv);
		borderPane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);

		
		
		stage.setScene(scene);
		stage.setTitle("GUI WINDOW");
		stage.show();
		return;



	}


	public static void main(String[] args) {
		launch(args);
	}



}

