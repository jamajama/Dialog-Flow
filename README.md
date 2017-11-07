Java SDK for api.ai
==================

The API.AI Java SDK makes it easy to integrate speech recognition with [API.AI](http://www.api.ai) natural language processing API on Android devices. API.AI allows using voice commands and integration with dialog scenarios defined for a particular agent in API.AI.

Authentication is accomplished through setting the client access token when initializing an [AIConfiguration](https://github.com/DHLSupplyChain/Api.AI/blob/master/libai/src/main/java/ai/api/AIConfiguration.java) object. The client access token specifies which agent will be used for natural language processing.

**Note:** The API.AI Java SDK only makes query requests, and cannot be used to manage entities and intents. Instead, use the API.AI user interface or REST API to  create, retrieve, update, and delete entities and intents.






