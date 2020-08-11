ORIGIN_WAR_PATH='/home/jenkins/lotteWebService/deploy/*.war'
ORIGIN_WAR_NAME=$(basename ${ORIGIN_WAR_PATH})
TARGET_PATH='/home/jenkins/lotteWebService/application.war'
WAR_BOX_PATH='/home/jenkins/lotteWebService/war/'

echo "  > 배포 WAR: "${ORIGIN_WAR_NAME}

echo "  > chmod 770 ${ORIGIN_WAR_PATH}"
sudo chmod 770 ${ORIGIN_WAR_PATH}

echo "  > cp ${ORIGIN_WAR_PATH} ${WAR_BOX_PATH}"
sudo cp ${ORIGIN_WAR_PATH} ${WAR_BOX_PATH}

echo "  > chown -h jenkins:jenkins ${WAR_BOX_PATH}${ORIGIN_WAR_NAME}"
sudo chown -h jenkins:jenkins ${WAR_BOX_PATH}${ORIGIN_WAR_NAME}

echo "  > sudo ln -s -f ${WAR_BOX_PATH}${ORIGIN_WAR_NAME} ${TARGET_PATH}"
sudo ln -s -f ${WAR_BOX_PATH}${ORIGIN_WAR_NAME} ${TARGET_PATH}