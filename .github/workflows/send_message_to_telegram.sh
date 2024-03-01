#!/bin/bash

SERVICE_URI=$(gcloud run services describe shoes-service --platform=managed --region=europe-central2 --format='value(status.url)')
PROJECT_NAME="Run_App"
SERVICE_NAME="$GITHUB_REPOSITORY"
COMMIT=$(git log --format=%s -n 1)
DEPLOYED_BY="$GITHUB_ACTOR"
DEPLOYMENT_DATE=$(date +'%Y-%m-%d %H:%M:%S')
DOCUMENTATION_URI="${SERVICE_URI}/swagger-ui/index.html"
GITHUB_URI="https://github.com/${GITHUB_REPOSITORY}"
CHAT_ID="$1"
BOT_TOKEN="$2"
PHOTO_URI="$3"


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


# send photo
curl --location "https://api.telegram.org/bot$BOT_TOKEN/sendPhoto" \
--header 'Content-Type: application/json' \
--data '{
    "chat_id" : "'"$CHAT_ID"'",
    "photo" : "'"$PHOTO_URI"'"
}'

# send notification text
curl --location "https://api.telegram.org/bot$BOT_TOKEN/sendMessage" \
--header 'Content-Type: application/json' \
--data '{
    "chat_id" : "'"$CHAT_ID"'",
    "text" : "'"$MESSAGE"'",
    "parse_mode" : "HTML",
}'
