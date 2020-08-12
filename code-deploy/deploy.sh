ORIGIN_WAR_PATH='/home/jenkins/lotteWebService/deploy/*.war'
ORIGIN_WAR_NAME=$(basename ${ORIGIN_WAR_PATH})
TARGET_PATH='/home/jenkins/lotteWebService/lotteWebService.war'
WAR_BOX_PATH='/home/jenkins/lotteWebService/deploy/'

echo "  > 배포 WAR: "${ORIGIN_WAR_NAME}

echo "  > chmod 770 ${ORIGIN_WAR_PATH}"
sudo chmod 770 ${ORIGIN_WAR_PATH}

echo "  > cp ${ORIGIN_WAR_PATH} ${WAR_BOX_PATH}"
sudo cp ${ORIGIN_WAR_PATH} ${WAR_BOX_PATH}

echo "  > chown -h jenkins:jenkins ${WAR_BOX_PATH}${ORIGIN_WAR_NAME}"
sudo chown -h jenkins:jenkins ${WAR_BOX_PATH}${ORIGIN_WAR_NAME}

echo "  > sudo ln -s -f ${WAR_BOX_PATH}${ORIGIN_WAR_NAME} ${TARGET_PATH}"
sudo ln -s -f ${WAR_BOX_PATH}${ORIGIN_WAR_NAME} ${TARGET_PATH}

echo "> 현재 실행중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f $ORIGIN_WAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $ORIGIN_WAR_NAME 배포"
nohup java -jar $ORIGIN_WAR_NAME