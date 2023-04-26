# board-spring-boot-starter
autoconfigure, 늘 쓰던 라이브러리와 설정을 프로젝트에 끌어올 순없을까?
<br><br><br>
*라이브러리 run as - maven install시 java version이 낮으면 오류가 발생하니 확인한다. <br>
board-spring-boot-starter 프로젝트는 java11로 configure build path 수정하여 install 되었다.

<br><br>
생성된 라이브러리를 직접 보고 싶다면 메이븐 레파지토리 폴더경로로 들어가 확인해보자, 아래는 직접확인한 경로예시이다.<br>
  C:\Users\409\.m2\repository\com\himedia <br>
  ![image](https://user-images.githubusercontent.com/120000929/234462482-718838e7-1a9e-4e63-b859-ed6b7f8ebb06.png)

  
  
<br><br><br>
프로젝트 pom파일에 생성한 라이브러리를 추가한다.
```
<dependency>
<groupId>com.himedia</groupId>
<artifactId>board-spring-boot-starter</artifactId>
<version>0.0.1-SNAPSHOT</version>
</dependency>
```
![image](https://user-images.githubusercontent.com/120000929/234462525-d6ef9f70-2253-4a1e-a88a-5e3b01e55d7b.png)


<br><br><br>
객체를 만들어 확인해보자, JDBCConnectionManager에서 불러온 JDBCConnectionManager가 잘만들어지는가.
```
package com.himedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

//우리가 생성했던 board-spring-boot-starter를 가져왔다.
import com.himedia.jdbc.util.JDBCConnectionManager;

@Service //컨테이너가 컴포넌트를 스캔하도록 추가
public class JDBCConnectionManagerRunner implements ApplicationRunner{

	@Autowired
	public JDBCConnectionManager connectionManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("커넥션 메니저"+connectionManager);
	}
  
}
```
![image](https://user-images.githubusercontent.com/120000929/234462540-6602f511-87ab-4dc9-8573-572d4e5b0441.png)
