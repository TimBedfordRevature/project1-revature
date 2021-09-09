<!DOCTYPE html>  
 <html>  
      <head>  
           <title>Webslesson Tutorial | Convert Data from Mysql to JSON Format using PHP</title>  
      </head>  
      <body>  
           <?php   
           $connect = mysqli_connect("localhost", "TimBedford", "H@l0Infin1t2021", "project1");  
           $sql = "SELECT * FROM tickets";  
           $result = mysqli_query($connect, $sql);  
           $json_array = array();  
           while($row = mysqli_fetch_assoc($result))  
           {  
                $json_array[] = $row;  
           }  
           echo json_encode($json_array);  
           ?>  
      </body>  
 </html>  
 
 