#!/bin/bash

SERVICE_URI="uri"
PROJECT_NAME="Run_App"
SERVICE_NAME="$GITHUB_REPOSITORY"
COMMIT="$GITHUB_SHA"
DEPLOYED_BY="$GITHUB_ACTOR"
DEPLOYMENT_DATE=$(date +'%Y-%m-%d %H:%M:%S')
DOCUMENTATION_URI="rrrr/swagger-ui/index.html"
GITHUB_URI="https://github.com/${GITHUB_REPOSITORY}"

echo "SERVICE_NAME: $SERVICE_URI"
echo "SERVICE_NAME: $PROJECT_NAME"
echo "SERVICE_NAME: $SERVICE_NAME"
echo "COMMIT: $COMMIT"
echo "DEPLOYED_BY: $DEPLOYED_BY"
echo "DEPLOYMENT_DATE: $DEPLOYMENT_DATE"
echo "DOCUMENTATION_URI: $DOCUMENTATION_URI"
echo "BOT_TOKEN: $BOT_TOKEN"
echo "GITHUB_URI: $GITHUB_URI"
echo "CHAT_ID: $CHAT_ID"
echo "https://api.telegram.org/bot$1/sendMessage"
echo

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
$BOT_TOKEN='6736641364:AAF9i-E9FL0GiWfrdFXFsKzz7ztHcO6RDms'

# Отправляем сообщение в Telegram с помощью curl
curl --location "https://api.telegram.org/bot$BOT_TOKEN/sendMessage" \
--form 'chat_id="-4183385105"' \
--form 'text="<b>✅Successful Deployment Notification✅</b>
Hey Team ✋,
Exciting news! Another successful deployment has just been completed on the server.

<b>🤖 Project Name:</b> [Specify the version number or description of the update]
<b>☁️ Service Name:</b> [Specify the version number or description of the update]
<b>📗 Version:</b> [Specify the version number or description of the update]
<b>📪 Commit:</b> [Provide the commit name or ID associated with this deployment]
<b>👨‍💻 Deployed By:</b> [Mention the name or username of the user who pushed the changes]
<b>📆 Deployment Date:</b> [Specify the date and time of the deployment]
<b>📄 Documentation URI:</b> [Specify the date and time of the deployment]
<b>🔍 Service URI:</b> [Specify the date and time of the deployment]
<b>☘️ Github URI:</b> [Specify the date and time of the deployment]


If you have any questions or need further information, don'\''t hesitate to contact us!
Best regards,
[Your Name or Team Name]"' \
--form 'parse_mode="HTML"'
