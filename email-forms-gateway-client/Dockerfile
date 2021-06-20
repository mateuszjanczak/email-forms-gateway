FROM node:16-alpine

WORKDIR client

COPY package.json .

RUN npm install

COPY . .

ENV REACT_APP_API_URL=http://localhost:8080

EXPOSE 3000

CMD ["npm", "start"]