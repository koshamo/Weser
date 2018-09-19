/*
 * Copyright [2018] [Dr. Jochen Raßler]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     or see LICENSE file in the project root
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package weser.gui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weser.gui.controls.WideScreenReader;

public class WeserGui extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		WideScreenReader reader = new WideScreenReader();
		mainPane.setCenter(reader);
		mainPane.setTop(buildControlBar());
		mainPane.setBottom(new Label("status"));
		
		Scene scene = new Scene(mainPane, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("WeSeR");
		primaryStage.show();
	}

	private Node buildControlBar() {
		VBox vbox = new VBox();
		vbox.getChildren().addAll(buildMenuBar(), buildButtonBar());
		return vbox;
	}

	private Node buildMenuBar() {
		return new Label("Menues");
	}

	private Node buildButtonBar() {
		return new Button("Button");
	}

}
