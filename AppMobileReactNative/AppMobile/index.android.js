import React, { Component, PropTypes } from 'react';

import SQLite from 'react-native-sqlite-storage';

import 
{
	 AppRegistry,
	 Text,
	 TextInput,
	 StyleSheet,
	 TouchableOpacity,
	 Navigator,
	 ListView,
	 View
} 
from 'react-native';

import { SubmitForm } from './submitForm.js';
import { FirstPage } from './firstPage.js';

const styles = StyleSheet.create({
	
	 container: {
		flex: 1,
		justifyContent: 'center',
		alignItems: 'center',
		backgroundColor: '#F5FCFF',
	 },

	 simpleText: {
		 fontSize: 20,
		 textAlign: 'left',
	 },

	 buttonText: {
		 fontSize: 20,
		 textAlign: 'center',
	 },
	 
	 welcome: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10,
	 },
	 
	 welcomeBlue: {
		 fontSize: 20,
		textAlign: 'center',
		margin: 10,
		color: '#80A4B3',
	 },
	 
	 instructions: {
		textAlign: 'center',
		color: '#333333',
		marginBottom: 5,
	 },
	 
});

class MyButton extends React.Component
{
	render()
	{
		return (
			<View>
				<Text style = {styles.welcomeBlue}> {this.props.label} </Text>
			</View>
		);
	}
}

export default class AppMobile extends Component 
{
	constructor()
	{
		super();

		const l_menuList = new ListView.DataSource({ 
			rowHasChanged: (l_row1, l_row2) => l_row1 !== l_row2
		});
		
		this.state = {
			dataSource: l_menuList.cloneWithRows(['Submit form', 'Location']),
		};
	}
	
	render()
	{
		return (
			<Navigator
				initialRoute = {{ title: 'GPS Locations', index: 0 }}
				renderScene = {(route, navigator) => 
					{
						if (route.index === 0)
						{
							return <FirstPage
										title = {route.title}

										onForward = {() => 
											{
												const nextIndex = route.index + 1;
												navigator.push({
													title: 'Scene: ' + nextIndex,
													index: nextIndex,
												})
											}}

											onBack = {() => 
												{
													if (route.index > 0)
													{
														navigator.pop();
													}
												}}
									/>
						}
						else
						{
							return <SubmitForm
								onBack = {() => 
												{
													if (route.index > 0)
													{
														navigator.pop();
													}
												}} 
							/>
						}
					}}
			/>
		);
	}
}

AppRegistry.registerComponent('AppMobile', () => AppMobile);