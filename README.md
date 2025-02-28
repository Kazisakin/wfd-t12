# team-12
Run Instruction for Spike-MapsWithGrids

Run the following command to the Directory "wfd-t12/"

$mkdir out
$javac --module-path "Your path to JavaFx lib" --add-modules javafx.controls,javafx.graphics -d out $(find src -name "*.java")
                            ex: javac --module-path /Users/kazisakin/Desktop/COURCES/javafx-sdk-17.0.14/lib --add-modules javafx.controls,javafx.graphics -d out $(find src -name "*.java")
$- cp -r src/resources out/
$ java --module-path "Your path to JavaFx lib" --add-modules javafx.controls,javafx.graphics -cp out WildfireApp

