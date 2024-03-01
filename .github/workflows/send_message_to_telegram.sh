#!/bin/bash

SERVICE_URI="uri"
PROJECT_NAME="Run_App"
SERVICE_NAME="$GITHUB_REPOSITORY"
COMMIT="$GITHUB_SHA"
DEPLOYED_BY="$GITHUB_ACTOR"
DEPLOYMENT_DATE=$(date +'%Y-%m-%d %H:%M:%S')
DOCUMENTATION_URI="rrrr/swagger-ui/index.html"
GITHUB_URI="https://github.com/${GITHUB_REPOSITORY}"

CHAT_ID="$1"
BOT_TOKEN="$2"

echo "SERVICE_URI = $SERVICE_URI"
echo "PROJECT_NAME = $PROJECT_NAME"
echo "SERVICE_NAME = $SERVICE_NAME"
echo "COMMIT = $COMMIT"
echo "DEPLOYED_BY = $DEPLOYED_BY"
echo "DEPLOYMENT_DATE = $DEPLOYMENT_DATE"
echo "DOCUMENTATION_URI = $DOCUMENTATION_URI"
echo "GITHUB_URI = $GITHUB_URI"
echo "BOT_TOKEN = $BOT_TOKEN"
echo "CHAT_ID = $CHAT_ID"


MESSAGE="<b>✅ Successful Deployment Notification ✅</b>
Hey Team ✋,
Exciting news! Another successful deployment has just been completed on the server.

<b>🤖 Project Name:</b> $PROJECT_NAME
<b>☁️ Service Name:</b> $SERVICE_NAME
<b>📗 Version:</b> $VERSION
<b>📪 Commit:</b> $COMMIT
<b>👨‍💻 Deployed By:</b> $DEPLOYED_BY
<b>📆 Deployment Date:</b> $DEPLOYMENT_DATE
<b>📄 Documentation URI:</b> $DOCUMENTATION_URI
<b>🔍 Service URI:</b> $SERVICE_URI
<b>☘️ Github URI:</b> $GITHUB_URI

If you have any questions or need further information, don't hesitate to contact us!
Best regards,
$DEPLOYED_BY"

echo "text = $MESSAGE"
echo "https://api.telegram.org/bot$BOT_TOKEN/sendMessage"

# Отправляем сообщение в Telegram с помощью curl
curl --location "https://api.telegram.org/bot$BOT_TOKEN/sendMessage" \
--header 'Content-Type: application/json' \
--data '{
    "chat_id" : "'"$CHAT_ID"'",
    "text" : "'"$MESSAGE"'",
    "parse_mode" : "HTML",
}'


6736641364:AAF9i-E9FL0GiWfrdFXFsKzz7ztHcO6RDms