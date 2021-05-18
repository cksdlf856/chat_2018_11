package sist.com.network;

import java.io.Serializable;

public class ChatInformation implements Serializable{
   private String id;
   private String pw;
   private String nickname;
   private String name;
   private String ip;
public String getId() {
   return id;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public void setId(String id) {
   this.id = id;
}
public String getPw() {
   return pw;
}
public void setPw(String pw) {
   this.pw = pw;
}
public String getNickname() {
   return nickname;
}
public void setNickname(String nickname) {
   this.nickname = nickname;
}
public String getName() {
   return name;
}
public void setName(String name) {
   this.name = name;
}
@Override
public String toString() {
	return "ChatInformation [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name + ", ip=" + ip
			+ "]";
}
     
}
