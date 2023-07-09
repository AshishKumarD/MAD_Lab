package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Program6 extends AppCompatActivity {
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program6);
        display=findViewById(R.id.display);
    }

    public void parsexml(View v){
        try {
            InputStream is=getAssets().open("city.xml");
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbFact.newDocumentBuilder();
            Document doc=db.parse(is);
            StringBuilder sb=new StringBuilder();
            sb.append("XML DATA");
            sb.append("\n-------------");
            NodeList nl=doc.getElementsByTagName("place");
            for(int i=0; i<nl.getLength();i++){
                Node node = nl.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element)node;
                    sb.append("\n Name:").append(getValue("name",element));
                    sb.append("\n Latitude:").append(getValue("lat",element));
                    sb.append("\n Longitude:").append(getValue("long",element));
                    sb.append("\n Temperature:").append(getValue("temperature",element));
                    sb.append("\n humidity").append(getValue("humidity",element));
                    sb.append("\n----------");
                }
            }
            display.setText(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            toastMessage("Error in reading XML FILE");
        }
    }
    public void parsejson(View V){
        String json;
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = getAssets().open("city.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jA = new JSONArray(json);
            sb.append("JSON DATA");
            sb.append("\n--------");
            for(int i=0;i<jA.length();i++){
                JSONObject jsonObject = jA.getJSONObject(i);
                sb.append("\n Name:").append(jsonObject.getString("name"));
                sb.append("\n Latidue:").append(jsonObject.getString("lat"));
                sb.append("\n Longitude:").append(jsonObject.getString("long"));
                sb.append("\n Temperature:").append(jsonObject.getString("temperature"));
                sb.append("\n Humidity:").append(jsonObject.getString("humidity"));
                sb.append("\n----------");
            }
            display.setText(sb.toString());
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
            toastMessage("Error in reading JSON file");
        }
    }
    private String getValue(String tag,Element element){
        return
                element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

}