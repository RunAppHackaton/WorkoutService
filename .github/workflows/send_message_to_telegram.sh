#!/bin/bash

SERVICE_URI="uri"
PROJECT_NAME="Run_App"
SERVICE_NAME="$GITHUB_REPOSITORY"
COMMIT="$GITHUB_SHA"
DEPLOYED_BY="$GITHUB_ACTOR"
DEPLOYMENT_DATE=$(date +'%Y-%m-%d %H:%M:%S')
DOCUMENTATION_URI="rrrr/swagger-ui/index.html"
GITHUB_URI="https://github.com/${GITHUB_REPOSITORY}"

BOT_TOKEN="$1"
CHAT_ID="$2"

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

# Отправляем сообщение в Telegram с помощью curl
curl --location "https://api.telegram.org/bot$BOT_TOKEN/sendMessage" \
--form "chat_id=$CHAT_ID" \
--form "text=$MESSAGE" \
--form "parse_mode=HTML"
