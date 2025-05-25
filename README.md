# BlogApp-backend


Json : 
{
	"info": {
		"_postman_id": "8beb2973-8764-4880-a091-a3308c7dd8c5",
		"name": "blog_app_api",
		"schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
		"_exporter_id": "45275041"
	},
	"item": [
		{
			"name": "user",
			"item": [
				{
					"name": "create user",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n     \"name\":\"Yashraj Singh\",\r\n     \"email\":\"Yashraj@mail.com\",\r\n     \"password\":\"password\",\r\n     \"about\":\"Description\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/users/"
					},
					"response": []
				},
				{
					"name": "get all users",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:3000/api/users/"
					},
					"response": []
				},
				{
					"name": "get user by Id",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:3000/api/users/2"
					},
					"response": []
				},
				{
					"name": "update user",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Test Singh\",\r\n    \"email\": \"test@mail.com\",\r\n    \"password\": \"test@123\", // not changable for now\r\n    \"about\": \"Description\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/users/3"
					},
					"response": []
				},
				{
					"name": "delete user",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Test Singh\",\r\n    \"email\": \"test@mail.com\",\r\n    \"password\": \"test@123\", // not changable for now\r\n    \"about\": \"Description\"\r\n}"
						},
						"url": "http://localhost:3000/api/users/3"
					},
					"response": []
				}
			]
		},
		{
			"name": "category",
			"item": [
				{
					"name": "get All Categories",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Test Singh\",\r\n    \"email\": \"test@mail.com\",\r\n    \"password\": \"test@123\", // not changable for now\r\n    \"about\": \"Description\"\r\n}"
						},
						"url": "http://localhost:3000/api/categories/"
					},
					"response": []
				},
				{
					"name": "create Category",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"categoryTitle\":\"Back End\",\r\n    \"categoryDescription\":\"This is about Backend Course\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/categories/"
					},
					"response": []
				},
				{
					"name": "update category",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"categoryTitle\": \"Back-End\",\r\n    \"categoryDescription\": \"This is about Backend Course\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/categories/3"
					},
					"response": []
				},
				{
					"name": "get Cateory By Id",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "delete Category",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"categoryTitle\":\"Back End\",\r\n    \"categoryDescription\":\"This is about Backend Course\"\r\n}"
						},
						"url": "http://localhost:3000/api/categories/4"
					},
					"response": []
				}
			]
		},
		{
			"name": "posts",
			"item": [
				{
					"name": "create post",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"title\": \"Back-End\",\r\n    \"content\": \"This is about Backend Course\",\r\n    \"categoryTitle\":\"CategoryRequest\"\r\n    // \"user\":\"This is user\"\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/user/1/category/1/posts"
					},
					"response": []
				},
				{
					"name": "get all posts",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:3000/api/posts?pageNumber=1&pageSize=1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "3000",
							"path": [
								"api",
								"posts"
							],
							"query": [
								{
									"key": "pageNumber",
									"value": "1"
								},
								{
									"key": "pageSize",
									"value": "1"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "update post",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"title\": \"Back-End\",\r\n    \"content\": \"Backend Course is available\",\r\n    \"categoryTitle\":\"CategoryRequest\"\r\n    // \"user\":\"This is user\"\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/posts/1"
					},
					"response": []
				},
				{
					"name": "delete post",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"title\": \"Back-End\",\r\n    \"content\": \"Backend Course is available\",\r\n    \"categoryTitle\":\"CategoryRequest\"\r\n    // \"user\":\"This is user\"\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/posts/1"
					},
					"response": []
				},
				{
					"name": "upload image",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "formdata",
							"formdata": [
								{
									"key": "image",
									"type": "file",
									"src": "/C:/Users/LAPUTER.IN/Downloads/May 5, 2025, 05_40_03 PM.png"
								}
							]
						},
						"url": "http://localhost:3000/api/post/image/upload/1"
					},
					"response": []
				},
				{
					"name": "get post by id",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"title\": \"Back-End\",\r\n    \"content\": \"Backend Course is available\",\r\n    \"categoryTitle\":\"CategoryRequest\"\r\n    // \"user\":\"This is user\"\r\n\r\n}"
						},
						"url": "http://localhost:3000/api/posts/1"
					},
					"response": []
				}
			]
		},
		{
			"name": "comments",
			"item": [
				{
					"name": "add comment",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"content\": \"This Back-End course is very impressive\"\r\n\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:3000/api/post/1/comments"
					},
					"response": []
				}
			]
		}
	]
}
