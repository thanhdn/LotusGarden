# LotusGarden
1. Download maven từ offical site: https://maven.apache.org/ <br/>
2. Set maven vào path, set MAVEN_HOME to environment variables trên windows. Ai dùng MAC hay Ubuntu desktop thì google cách set hỉ <br/>
3. Clone project từ Git hub (Dùng git bash để clone hoặc down load thẳng rồi extracts ra cũng được) <br/>
4. Mở terminal, cd vào thư mục project, gõ lệnh mvn eclipse:eclipse <br/>
5. Mở eclipse lên (eclipse nào cũng được miễn là có sẵn maven plugin với phải là eclipse j2ee)<br/>
6. Import project vào eclipse<br/>
7. Chạy script sql db.sql (Ở đây tôi dùng mysql, sau này sẽ switch qua mongoDB). Sau khi chạy script thành công, các bác vào file src/main/resources/data_connection.properties và sửa lại thông tin kết nối db tương ứng<br/>
8. Bấm vào project trên eclipse chọn mvn clean<br/> 
9. Bấm vào project trên eclipse chọn mvn install<br/>
10. Bấm vào project chọn run as, run bằng cái server mà các bác đã config trong eclipse. Cách config tomcat trên eclipse thì các bác tự làm nhé<br/>


Project này tôi dùng để learning là chủ yếu nên nó chưa có gì cả ngoài một cái form ghẻ và login sử dụng spring sercutiry. Các bác muốn vọc angular js và spring boot thì qua cái SchoolSchedule với thằng SchoolCalendar
