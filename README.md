# ChatGpt-OpenAi:
![maxresdefault (2)](https://user-images.githubusercontent.com/112378013/213863609-7b9f215f-b4e6-4878-a617-fb46302fbe53.jpg)

Android app that is built by ChatGPT from OpenAI 📱 ChatGPT Android demonstrates OpenAI's ChatGPT on Android with Stream Chat SDK for Compose.

**ChatGPT Android** demonstrates [OpenAI's ChatGPT](https://chat.openai.com/chat) on Android with [Stream Chat SDK for Compose](https://getstream.io/chat/sdk/compose?utm_source=Github&utm_medium=Github_Repo_Content_Ad&utm_content=Developer&utm_campaign=Github_Dec2022_Jaewoong&utm_term=DevRelOss).

The purpose of this repository is to demonstrate below:

- Demonstrates [ChatGPT](https://chat.openai.com/chat)'s unofficial APIs.
- Implementing entire UI elements with Jetpack Compose.
- Implementation of Android architecture components with Jetpack libraries such as Hilt and AppStartup.
- Performing background tasks with Kotlin Coroutines.
- Integrating chat systems with Stream Chat SDK for real-time event handling.

## Features:

- drawer swipe
- transparent status bar
- themed bottom bar
- back button close drawer
- startup keyboard auto open
- chat keyboard auto dismiss


## ChatGPT: The Most Advanced AI Chatbot in 2022​
## OpenAI release a Optimizing Language Model for Dialogue name ChatGPT on November 30, 2022.

Once it was released, ChatGPT gained great attention and traffic, causing much discussion on online platforms. What is the magic of ChatGPT that makes people so crazy about it? In this article, we will introduce ChatGPT in detail.

## What is ChatGPT?

ChatGPT is a large language model developed by OpenAI that can be used for natural language processing tasks such as text generation and language translation. It is based on the GPT-3.5 (Generative Pretrained Transformer 3.5) model, which is one of the largest and most advanced language models currently available.

One of the key features of ChatGPT is its ability to generate human-like text responses to prompts. This makes it useful for a wide range of applications, such as creating chatbots for customer service, generating responses to questions in online forums, or even creating personalized content for social media posts.


## How to Use ChatGPT?

To use ChatGPT, you will need to have access to the OpenAI API. Once you have obtained an API key, you can use the ChatGPT model by sending it a prompt in the form of a text string. The model will then generate a response based on the information it has been trained on.

## Steps of Use ChatGPT:

- Open openai.com，Register an account and log in (if you have an account, log in directly)
- Click ChatGPT on the bottom left
- Click Try it now at chat.openai.com.
- Enter the question you need to query in the input box at the bottom

![6th September Defence Day Poster - Made with PosterMyWall](https://user-images.githubusercontent.com/112378013/213864108-39ed35c5-ce00-44b8-a2c9-46888846fdfc.jpg)

![6th September Defence Day Poster - Made with PosterMyWall (1)](https://user-images.githubusercontent.com/112378013/213864114-d58aeabd-1413-4df7-88ff-9a0434eb073b.jpg)

![6th September Defence Day Poster - Made with PosterMyWall (2)](https://user-images.githubusercontent.com/112378013/213864120-68895828-0247-40a5-ae1d-cdc9a20750f9.jpg)

## The Application of ChatGPT:

ChatGPT can be used for a wide range of natural language processing tasks. Some of the potential applications of ChatGPT include:

- **Text generation:** ChatGPT can be used to generate human-like text responses to prompts, which makes it useful for creating chatbots for customer service, generating responses to questions in online forums, or even creating personalized content for social media posts.
 
- **Language translation:** ChatGPT can also be used for language translation tasks. By providing the model with a text prompt in one language and specifying the target language, the model can generate accurate and fluent translations of the text.
 
- **Text summarization:** ChatGPT can be used to generate summaries of long documents or articles. This can be useful for quickly getting an overview of a text without having to read the entire document.
 
- **Sentiment analysis:** ChatGPT can be used to analyze the sentiment of a given text. This can be useful for understanding the overall tone and emotion of a piece of writing, or for detecting the sentiment of customer feedback in order to improve customer satisfaction.
 
Overall, ChatGPT is a versatile tool that can be used for a wide range of natural language processing tasks. The specific applications of the model will depend on the needs and goals of the user.

## Who Invented ChatGPT?

ChatGPT is based on the GPT-3 architecture, which was developed by a team of researchers at OpenAI.

The development of the GPT-3 architecture was led by Alec Radford, Jeffrey Wu, Rewon Child, and David Luan, who are all researchers at OpenAI. The team worked closely with a number of other researchers and engineers at OpenAI to develop and train the GPT-3 model on a large corpus of text data.

The GPT-3 architecture was introduced in a research paper published in 2020, which described the model’s ability to generate human-like text responses to prompts. Since then, the GPT-3 model has been widely used by researchers and developers for a variety of natural language processing tasks, including text generation, language translation, and text summarization.

Overall, the development of ChatGPT was the result of a collaborative effort by a team of researchers and engineers at OpenAI. The model is based on the GPT-3 architecture, which was developed by Alec Radford, Jeffrey Wu, Rewon Child, and David Luan.

## Is ChatGPT Free to Use?

ChatGPT is currently free to use, you just need to register a ChatGPT account in the supported countries and regions to use it. Due to the large number of users, there may be delays or errors such as, ChatGPT error, ChatGPT network error, ChatGPT is at capacity right now. If you encounter these problems, it is recommended to switch to a new account.

Gpt-3 model training cost is huge, Sam Altman, the head of OpenAI, said that ChatGPT cost “probably single-digits cents” per use, and we think there will be a fee plan in the future.

## 🏛️ Architecture

**ChatGPT Android** follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

![figure0](https://user-images.githubusercontent.com/112378013/213863765-3d4b3a1a-e5a5-4b09-877d-d1108acf5f9b.png)


**ChatGPT Android** was built with [Guide to app architecture](https://developer.android.com/topic/architecture), so it would be a great sample to show how the architecture works in real-world projects.<br>

The overall architecture is composed of two layers; UI Layer and the data layer. Each layer has dedicated components and they each have different responsibilities.
The arrow means the component has a dependency on the target component following its direction.

### Architecture Overview

![figure1](https://user-images.githubusercontent.com/112378013/213863783-be441421-d8ad-48c0-a3dd-ee73c3fc9eea.png)


Each layer has different responsibilities below. Basically, they follow [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf).

### UI Layer
![figure2](https://user-images.githubusercontent.com/112378013/213863788-7558c390-bb0f-48e6-b42b-b90814eaff93.png)


The UI Layer consists of UI elements like buttons, menus, tabs that could interact with users and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.

### Data Layer
![figure3](https://user-images.githubusercontent.com/112378013/213863795-594642a8-a503-4c35-b55a-ba538b232577.png)


The data Layer consists of repositories, which include business logic, such as querying data from the local database and requesting remote data from the network. It is implemented as an offline-first source of business logic and follows the [single source of truth](https://en.wikipedia.org/wiki/Single_source_of_truth) principle.<br>

For more information about the overall architecture, check out **[Build a Real-Time WhatsApp Clone With Jetpack Compose](https://getstream.io/blog/build-whatsapp-clone/)**.

## Modularization
![figure4](https://user-images.githubusercontent.com/112378013/213863806-5391f73c-62a9-43fd-b2cc-20e632dcce2a.png)



**ChatGPT Android** adopted modularization strategies below:

- **Reusability**: Modulizing reusable codes properly enable opportunities for code sharing and limits code accessibility in other modules at the same time.

- **Parallel Building**: Each module can be run in parallel and it reduces the build time.

- **Decentralized focusing**: Each developer team can assign their dedicated module and they can focus on their own modules.


## 💯 MAD Score

![summary](https://user-images.githubusercontent.com/24237865/158918011-bc766482-ec83-47dd-9237-d8a226cab263.png)


## :tada: CONTACT ME FOR SOURCE CODES_NOW_:

Your desired place for software development.High-quality software guaranteed.

<a href="https://wa.link/1f2deb"><img src="https://logos-world.net/wp-content/uploads/2020/05/WhatsApp-Symbol.png" width="170" height="90" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

## :tada: VISIT ME ON SOCIAL MEDIA

<a href="https://www.facebook.com/profile.php?id=100093770020415&mibextid=ZbWKwL"><img src="https://static-00.iconduck.com/assets.00/facebook-icon-512x512-seb542ju.png" width="100" height="90" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

